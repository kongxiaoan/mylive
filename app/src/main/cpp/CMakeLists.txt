#指定 Cmake 最低版本
cmake_minimum_required(VERSION 3.4.1)

#找到包含所有的cpp文件
file(GLOB allCpp *.cpp)

#打印当前 cmakeLists 的路径
message("当前cmakel路径: ${CMAKE_SOURCE_DIR} \n cpu架构：${CMAKE_ANDROID_ARCH_ABI}")

message(allCpp = ${allCpp})
add_library(
        ffmpeg_lib

        SHARED

        ${allCpp} utils/utils.cpp)

find_library(
        log-lib

        log)

# 引入FFmpeg的头文件
include_directories(${CMAKE_SOURCE_DIR}/include)

# 引入FFmpeg的库文件，设置内部的方式引入，指定库的目录是 -L  指定具体的库-l
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${CMAKE_SOURCE_DIR}/${CMAKE_ANDROID_ARCH_ABI}")

target_link_libraries(
        ffmpeg_lib

        avfilter
        avformat
        avcodec
        avutil
        swresample
        swscale

        ${log-lib})