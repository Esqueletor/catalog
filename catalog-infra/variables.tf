variable "mongo_container_name" {
  type        = string
  description = "Name of the MongoDB container"
  default     = "catalog-mongo"
}

variable "mongo_image" {
  type        = string
  description = "MongoDB Docker image"
  default     = "mongo:7"
}

variable "mongo_external_port" {
  type        = number
  description = "External port for MongoDB"
  default     = 27017
}

variable "docker_network_name" {
  type        = string
  description = "Docker network name"
  default     = "catalog_net"
}

variable "mongo_volume_name" {
  type        = string
  description = "MongoDB volume name"
  default     = "catalog_mongo_data"
}

variable "catalog_container_name" {
  type    = string
  default = "catalog-app"
}

variable "catalog_image" {
  type    = string
  default = "catalog:local"
}

variable "catalog_external_port" {
  type    = number
  default = 8080
}

variable "mongo_database_name" {
  type    = string
  default = "catalog"
}
