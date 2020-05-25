#!/bin/bash
# 20200525
# define variable
application_name="ntu-claims-approval-system"
container_name="${application_name}-mysql"

# clean up mysql container
docker container stop "${container_name}"
docker container rm "${container_name}"
