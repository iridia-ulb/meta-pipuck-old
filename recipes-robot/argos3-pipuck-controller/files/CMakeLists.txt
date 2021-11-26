cmake_minimum_required(VERSION 2.8.12)
project(my_pipuck_controller)

set(ARGOS_BUILD_FOR "pi-puck")

find_package(ARGoS REQUIRED)
include_directories(${ARGOS_INCLUDE_DIRS})
link_directories(${ARGOS_LIBRARY_DIR})
link_libraries(${ARGOS_LDFLAGS})

# compile test controller
add_library(my_pipuck_controller SHARED
  my_pipuck_controller.h
  my_pipuck_controller.cpp)
target_link_libraries(my_pipuck_controller
    argos3core_${ARGOS_BUILD_FOR}
    argos3plugin_${ARGOS_BUILD_FOR}_pipuck)
install(TARGETS my_pipuck_controller LIBRARY DESTINATION lib/argos3)

# configure experiment
configure_file(
  ${CMAKE_CURRENT_SOURCE_DIR}/configuration.argos.in
  ${CMAKE_CURRENT_BINARY_DIR}/configuration.argos)
install(FILES ${CMAKE_CURRENT_BINARY_DIR}/configuration.argos DESTINATION share/argos3)

