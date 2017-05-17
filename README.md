# png图片压缩及转webp

## 1、使用方法
使用JNI实现了java png图片转化为webp格式和图片的压缩，是对[webp-imageio](https://bitbucket.org/luciad/webp-imageio) 和  [libimagequant](https://github.com/ImageOptim/libimagequant) 的封装。
代码已完成了对c程序的封装,可运行在windows和linux环境。java代码直接打成jar后就能使用。

*压缩图片*
```java
PngQuant pngQuant = new PngQuant();
pngQuant.setQuality(20, 60);
pngQuant.setSpeed(10);
BufferedImage image = ImageIO.read(new File("E:\\test.png"));

BufferedImage remapped = pngQuant.getRemapped(image);
ImageIO.write(remapped, "png", new File("E:\\test.min.png"));
```

*图片转webp格式*
```java

// Obtain an image to encode from somewhere
BufferedImage image = ImageIO.read(new File("E:\\test.png"));

// Obtain a WebP ImageWriter instance
ImageWriter writer = ImageIO.getImageWritersByMIMEType("image/webp").next();

// Configure encoding parameters
WebPWriteParam writeParam = new WebPWriteParam(writer.getLocale());
writeParam.setCompressionMode(WebPWriteParam.LOSSLESS_COMPRESSION);

// Configure the output on the ImageWriter
writer.setOutput(new FileImageOutputStream(new File("E:\test.webp")));

// Encode
writer.write(null, new IIOImage(image, null, null), writeParam);
```

## 2、jar包测试
可运行命令`java -jar xxxx.jar`测试