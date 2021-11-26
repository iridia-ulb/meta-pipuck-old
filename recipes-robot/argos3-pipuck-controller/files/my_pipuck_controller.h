#include <argos3/core/control_interface/ci_controller.h>

namespace argos {

   class CMyPiPuckController : public CCI_Controller {

   public:

      CMyPiPuckController() {}

      virtual ~CMyPiPuckController() {}

      virtual void Init(TConfigurationNode& t_tree);

   };
}
