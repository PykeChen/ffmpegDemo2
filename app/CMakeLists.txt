# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# set(CURRENT_DIR ${CMAKE_SOURCE_DIR})

# 在Gradle Console输出信息
# CMAKE_SOURCE_DIR: E:/MyApplication2/app
message("CURRENT_DIR:" ${CMAKE_SOURCE_DIR})

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( MyFFmpeg
        SHARED
        src/main/cpp/native-lib.cpp )


find_library( log-lib
        log )

find_library( android-lib
        android )

# 设置ffmpeg库所在路径的目录
set(distribution_DIR ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI})

add_library( libffmpeg
        SHARED
        IMPORTED )
set_target_properties( libffmpeg
        PROPERTIES IMPORTED_LOCATION
        ${distribution_DIR}/libffmpeg.so)


# 添加ffmpeg头文件路径
include_directories(src/main/jniLibs/include)

target_link_libraries( MyFFmpeg
        libffmpeg
        ${log-lib}
        ${android-lib} )
