package com.ykf.suanfa.amr;

import it.sauronsoftware.jave.*;

import java.io.File;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2019-04-01 13:33
 */
public class test {

    public static void main(String[] args) {
        File source = new File("E://123.amr");
        File target = new File("E://123.mp3");
//        AudioUtils.amrToMp3(source, target);

        convert(source,target,"mp3");
    }

    public static void convert(File source, File target, String format) {
        if (!source.exists()) {
            throw new IllegalArgumentException("source file does not exists: " + source.getAbsoluteFile());
        } else {
            AudioAttributes audio = new AudioAttributes();
            Encoder encoder = new IgnoreErrorEncoder();
            audio.setCodec("libmp3lame");
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat(format);
            attrs.setAudioAttributes(audio);

            try {
                encoder.encode(source, target, attrs);
            } catch (Exception var7) {
                throw new IllegalStateException("convert amr to " + format + " error: ", var7);
            }
        }
    }
}