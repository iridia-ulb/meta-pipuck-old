# Base this image on core-image-base
include pipuck-image-base.bb

COMPATIBLE_MACHINE = "^rpi$"

# Additional packages
CORE_IMAGE_EXTRA_INSTALL += "  argos3-dev argos3-pipuck-dev lua-dev opencv libopencv-core-dev libopencv-imgproc-dev python3 python3-modules"


