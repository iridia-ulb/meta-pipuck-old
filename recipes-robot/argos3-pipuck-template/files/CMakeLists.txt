cmake_minimum_required(VERSION 2.8.12)
project(my_pipuck_controller)

set(ARGOS_BUILD_FOR "pi-puck")
set(ARGOS_BUILD_FOR_SIMULATOR FALSE)

find_path(ARGOS_INCLUDE_DIRS
  NAMES core/config.h
  PATH_SUFFIXES argos3
  DOC "ARGoS include directory"
)

find_library(ARGOS_CORE_LIB
  NAMES argos3core_${ARGOS_BUILD_FOR}
  PATH_SUFFIXES argos3  
  DOC "ARGoS core library"
)

find_library(ARGOS_PIPUCK_LIB
  NAMES argos3plugin_${ARGOS_BUILD_FOR}_pipuck
  PATH_SUFFIXES argos3  
  DOC "ARGoS core library"
)

# compile test controller
add_library(my_pipuck_controller MODULE
  my_pipuck_controller.h
  my_pipuck_controller.cpp)
target_link_libraries(my_pipuck_controller
    ${ARGOS_CORE_LIB}
    ${ARGOS_PIPUCK_LIB})

# configure experiment
configure_file(
  ${CMAKE_CURRENT_SOURCE_DIR}/configuration.argos.in
  ${CMAKE_CURRENT_BINARY_DIR}/configuration.argos)

