package org.tyaa.bytebuffer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 *
 * @author Юрий
 */
public class ByteBufferEx
{
    /**
     * @param args the command line arguments
     */
    private static ByteBuffer byteBuffer;
    
    public static void main(String[] args)
    {
        byteBuffer = ByteBuffer.allocate(10);
        try {    
            byteBuffer.put("Hello".getBytes("utf-8"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Error1");
        }
        getByteBufState();
        byteBuffer.flip();
        getByteBufState();
        byteBuffer.get();
        byteBuffer.get();
        byteBuffer.get();
        getByteBufState();
        byteBuffer.compact();
        getByteBufState();
        byteBuffer.clear();
        getByteBufState();
    }
    
    private static void getByteBufState()
    {
        System.out.println("pos = " + byteBuffer.position()
            + "  lim = " + byteBuffer.limit()
            + "  cap = " + byteBuffer.capacity());
    }
    
}
