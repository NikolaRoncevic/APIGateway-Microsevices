#!/bin/sh

./consul agent -config-dir=/consul-config &

java -jar productservice-1.0.0.jar