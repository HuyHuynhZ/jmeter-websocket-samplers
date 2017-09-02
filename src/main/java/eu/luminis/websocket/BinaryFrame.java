/*
 * Copyright 2016, 2017 Peter Doornbosch
 *
 * This file is part of JMeter-WebSocket-Samplers, a JMeter add-on for load-testing WebSocket applications.
 *
 * JMeter-WebSocket-Samplers is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * JMeter-WebSocket-Samplers is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package eu.luminis.websocket;

import eu.luminis.jmeter.wssampler.BinaryUtils;


public class BinaryFrame extends DataFrame {

    private byte[] data;
    int nrBytesPrintedInToString = 16;

    public BinaryFrame(byte[] payload) {
        super(0);
        data = payload;
    }

    public BinaryFrame(byte[] payload, int size) {
        super(size);
        data = payload;
    }

    public byte[] getBinaryData() {
        return data;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public String toString() {
        if (data.length > 0)
            return "Binary frame, payload (length " + data.length + "): " + BinaryUtils.formatBinary(data, nrBytesPrintedInToString) + (data.length > nrBytesPrintedInToString? " ...": "");
        else
            return "Binary frame, empty payload";
    }

    @Override
    protected byte[] getPayload() {
        return data;
    }

    @Override
    protected byte getOpCode() {
        return OPCODE_BINARY;
    }

    @Override
    public String getTypeAsString() {
        return "binary";
    }

}

