/*
 * $Id$
 *
 * Copyright (c) 2010, Autonomy Systems Ltd.
 *
 * Last modified by $Author$ on $Date$
 */
package com.autonomy.integration.processor;

import com.autonomy.aci.client.services.ProcessorException;
import com.autonomy.aci.client.services.impl.AbstractStAXProcessor;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * A processor for converting a query response into {@link FlatDocuments}.
 */
public class FlatDocumentsProcessor extends AbstractStAXProcessor<FlatDocuments> {
    @Override
    public FlatDocuments process(final XMLStreamReader reader) {
        final FlatDocuments results = new FlatDocuments();

        int numHits = -1;

        try {
            while (reader.hasNext()) {
                if (reader.next() == XMLStreamReader.START_ELEMENT) {
                    if ("autn:numhits".equals(reader.getLocalName())) {
                        numHits = Integer.parseInt(reader.getElementText());
                    }

                    if ("autn:state".equals(reader.getLocalName())) {
                        results.setStateToken(reader.getElementText());
                    }

                    if ("autn:hit".equals(reader.getLocalName())) {
                        results.add(parseAutnHit(reader));
                    }

                    if ("autn:warning".equals(reader.getLocalName())) {
                        results.addWarning(reader.getElementText());
                    }
                }
            }
        }
        catch (final XMLStreamException xmlse) {
            throw new ProcessorException(xmlse);
        }

        if (numHits != results.size()) {
            throw new ProcessorException("numhits: " + numHits + ", size: " + results.size());
        }

        return results;
    }

    private static FlatDocument parseAutnHit(final XMLStreamReader reader) throws XMLStreamException {
        final FlatDocument document = new FlatDocument();

        while (reader.hasNext()) {
            reader.next();

            if ("autn:hit".equals(reader.getLocalName())) {
                break;
            }
            else if ("autn:content".equals(reader.getLocalName())) {
                parseContentFields(document, reader);
            }
            else if (reader.getLocalName().startsWith("autn:")) {
                document.setAutnFieldValue(reader.getLocalName(), reader.getElementText());
            }
            else {
                throw new ProcessorException("Unexpected tag: " + reader.getLocalName());
            }
        }

        return document;
    }

    private static void parseContentFields(final FlatDocument document, final XMLStreamReader reader) throws XMLStreamException {
        // Starting at <autn:content>, Grab the <DOCUMENT> tag
        reader.next();

        if (!"DOCUMENT".equals(reader.getLocalName())) {
            // Do we need to allow a closing </autn:content> tag too?
            throw new ProcessorException("Expected <DOCUMENT>, found: " + reader.getLocalName());
        }

        while (reader.hasNext()) {
            reader.next();

            if ("DOCUMENT".equals(reader.getLocalName()) && reader.getEventType() == XMLStreamReader.END_ELEMENT) {
                break;
            }
            else {
                document.addContentFieldValue(reader.getLocalName(), reader.getElementText());
            }
        }

        // Grab the </autn:content>
        reader.next();

        if (!"autn:content".equals(reader.getLocalName())) {
            throw new ProcessorException("Expected </autn:content>, found: " + reader.getLocalName());
        }
    }
}
