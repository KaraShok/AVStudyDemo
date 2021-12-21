# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.10.2)

# Declares and names the project.

project("pusher")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        pusher

        # Sets the library as a shared library.
        STATIC

        # Provides a relative path to your source file(s).
        pusher.cpp)

include_directories(${CMAKE_SOURCE_DIR}/armeabi-v7a/facc/include)

target_link_libraries(pusher -Wl,--whole-archive ${CMAKE_SOURCE_DIR}/armeabi-v7a/facc/libfaac.a -Wl,--no-whole-archive)
#add_library( facc STATIC IMPORTED)
#set_target_properties( facc PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/armeabi-v7a/facc/libfaac.a)

include_directories(${CMAKE_SOURCE_DIR}/armeabi-v7a/rtmpdump/include)

add_library( rtmp STATIC IMPORTED)
set_target_properties( rtmp PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/armeabi-v7a/rtmpdump/librtmp.a)

include_directories(${CMAKE_SOURCE_DIR}/armeabi-v7a/x264/include)

add_library( x264 STATIC IMPORTED)
set_target_properties( x264 PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/armeabi-v7a/x264/libx264.a)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        pusher
        -landroid
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})