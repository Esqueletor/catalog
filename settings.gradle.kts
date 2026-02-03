rootProject.name = "catalog"

include("catalog-domain")
include("catalog-infrastructure")
include("catalog-application")
include("catalog-boot")

rootProject.name = "catalog"

project(":catalog-domain").projectDir = file("src/catalog-domain")
project(":catalog-application").projectDir = file("src/catalog-application")
project(":catalog-infrastructure").projectDir = file("src/catalog-infrastructure")
project(":catalog-boot").projectDir = file("src/catalog-boot")