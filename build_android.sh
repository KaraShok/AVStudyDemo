#用于编译安卓平台的脚本
#!/bin/bash
#定义几个变量
ARCH=arm
CPU=armv7-a
export NDK_PATH=/Users/karashokz/Library/Android/sdk/ndk/21.4.7075529
PREFIX=$(pwd)/android/$ARCH/$CPU
ADDI_CFLAGS="-marm -mno-stackrealign"
TOOLCHAIN=$NDK_PATH/toolchains/arm-linux-androideabi-4.9
ANDROID_TOOLCHAINS_PATH=$NDK_PATH/toolchains/llvm/prebuilt/darwin-x86_64
CROSS_PREFIX=$ANDROID_TOOLCHAINS_PATH/bin/arm-linux-androideabi-
SYSROOT=$ANDROID_TOOLCHAINS_PATH/sysroot
#用CC变量和CXX变量指定Cmake使用的编译器
#没有export，就相当于脚本的临时变量
#加了export，就变成了当前会话的环境变量
export CC=$ANDROID_TOOLCHAINS_PATH/bin/armv7a-linux-androideabi23-clang
export CXX=$ANDROID_TOOLCHAINS_PATH/bin/armv7a-linux-androideabi23-clang++

#执行 .configure文件
./configure --prefix=$PREFIX \
	--enable-gpl \
	--disable-static \
	--enable-shared \
	--enable-small \
	--disable-programs \
	--disable-ffmpeg \
	--disable-ffplay \
	--disable-ffprobe \
	--disable-doc \
	--arch=$ARCH \
	--cpu=$CPU \
	--cross-prefix=$CROSS_PREFIX \
	--enable-cross-compile \
	--sysroot=$SYSROOT \
	--target-os=android \
	--extra-cflags="-Os -fpic -mno-stackrealign" \
	--extra-ldflags="$ADDI_LDFLAGS" \
	--cc=$CC \
	--cxx=$CXX \
	--disable-x86asm \
#运行 Makefile
make clean
make
make install