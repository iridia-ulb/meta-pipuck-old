# Base this image on core-image-base
include pipuck-image-base.bb

COMPATIBLE_MACHINE = "^rpi$"

# Additional packages
CORE_IMAGE_EXTRA_INSTALL += " argos3-dev argos3-pipuck-dev argos3-pipuck-template opencv libopencv-core-dev libopencv-imgproc-dev cmake"

# Add compiler, debugger, make etc.
EXTRA_IMAGE_FEATURES += " tools-sdk tools-debug"


