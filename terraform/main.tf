terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 3.0"
    }
  }
}

provider "docker" {}

resource "docker_network" "catalog_net" {
  name = var.docker_network_name
}

resource "docker_volume" "mongo_data" {
  name = var.mongo_volume_name
}

resource "docker_container" "mongo" {
  name  = var.mongo_container_name
  image = var.mongo_image

  networks_advanced {
    name = docker_network.catalog_net.name
  }

  ports {
    internal = 27017
    external = var.mongo_external_port
  }

  volumes {
    volume_name    = docker_volume.mongo_data.name
    container_path = "/data/db"
  }
}

resource "docker_container" "catalog" {
  name = var.catalog_container_name
  image = var.catalog_image

  depends_on = [
    docker_container.mongo
  ]

  networks_advanced {
    name = docker_network.catalog_net.name
  }


  env = [
    "SPRING_DATA_MONGODB_URI=mongodb://${var.mongo_container_name}:27017/${var.mongo_database_name}"
  ]



  ports {
    internal = 8080
    external = var.catalog_external_port
  }
}