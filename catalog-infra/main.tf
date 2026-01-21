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
  name = "catalog_net"
}

resource "docker_container" "mongo" {
  name  = "catalog-mongo"
  image = "mongo:7"

  networks_advanced {
    name = docker_network.catalog_net.name
  }

  ports {
    internal = 27017
    external = 27017
  }
}