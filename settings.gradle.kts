rootProject.name = "catalog"

include("domain")
include("infrastructure")
include("application")
include("boot")

rootProject.name = "catalog"

include(
    "domain",
    "application",
    "infrastructure",
    "boot"
)