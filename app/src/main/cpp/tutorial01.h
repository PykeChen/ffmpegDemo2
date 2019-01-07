// tutorial01.c
//
// This tutorial was written by Stephen Dranger (dranger@gmail.com).
//
// Code based on a tutorial by Martin Bohme (boehme@inb.uni-luebeckREMOVETHIS.de)
// Tested on Gentoo, CVS version 5/01/07 compiled with GCC 4.1.1

// A small sample program that shows how to use libavformat and libavcodec to
// read video from a file.
//
// Use the Makefile to build all examples.
//
//      or gcc -Wall -ggdb tutorial01.c -D_GNU_SOURCE=1 -D_REENTRANT -I/usr/local/include -I/usr/include/SDL -c -o obj/tutorial01.o
//
// Run using
//
// tutorial01 myvideofile.mpg
//
// to write the first five frames from "myvideofile.mpg" to disk in PPM format.

extern "C" {
#include <libavcodec/avcodec.h>

void SaveFrame(AVFrame *pFrame, int width, int height, int iFrame, const char *dirPath);
/**
 * 保存前5桢图像到图片中
 * @param filePath 视频文件路径
 * @param frameDirPath 帧保存目录
 */
int SaveHead5Frame2Disk(const char *filePath, const char *frameDirPath);

}


