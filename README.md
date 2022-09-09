# CustomProgressDialog

[![](https://jitpack.io/v/ugny/customprogressdialog.svg)](https://jitpack.io/#ugny/customprogressdialog)

Bu kütüphane `Deprecated` olmuş `android.app.ProgressDialog` sınıfına alternatif olarak yazılmıştır.

Bu <code>CustomProgressDialog</code> tasarımı mesaj olmadan da kullanılabilir.

Yazılımcı isterse geliştirdiği uygulamanın `launcher activity` sayfasında sınıfın `static` fonksiyonlarını kullanarak 
sınıfın özelliklerine bir kereliğine atama yapabilir ve yapmış olduğu tasarımı projenin her yerinde kullanabilir.
Yazılımcı

* `setBackgroundColor(int)` fonksiyonuyla dialog penceresinin arka plan rengini,
    
* `setIndeterminateTintAndTextColor(int)` fonksiyonuyla progressBar'ın `indeterminateTint` ile mesajın
      `textColor` renklerini
      
özelleştirebilir.

Yazılımcı herhangi bir atama yapmazsa sınıfın <b>varsayılan</b> özellikleri geçerli olacaktır.

Renk değişkenlerine atama işlemi eğer <code>color</code> dosyasından yapılacaksa
  <code>context.getResources().getColor(R.color.your_color)</code> yöntemi kullanılmalıdır.
  </p>

******************************************************************************************

### Kütüphanenin *gradle* ile kullanımı

> Step 1. Add the JitPack repository to your build file

##### Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
}
```
  
> Step 2. Add the dependency

```gradle
dependencies {
    implementation 'com.github.ugny:customprogressdialog:Tag'
}
```

******************************************************************************************

### Kütüphanenin *maven* ile kullanımı

> Step 1. Add the JitPack repository to your build file

```gradle
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

> Step 2. Add the dependency

```gradle
<dependency>
    <groupId>com.github.ugny</groupId>
    <artifactId>customprogressdialog</artifactId>
    <version>Tag</version>
</dependency>
```
