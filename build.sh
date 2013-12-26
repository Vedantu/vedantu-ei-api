#!/bin/bash

#
# [CONFIGURABLE PROPERTIES]
# REQ_JAVA_HOME       -- the base directory of your jdk
#                        eg. /usr/local/j2sdk1.4.2
# REQ_APP_SERVER_HOME -- the base directory of your server
#                        eg. /usr/local/apache-tomcat-5.5.12
#                        This will be used to refer jars like servlet-api.jar
#                        and will refer only the [lib], [common/lib] directories
#                        of your application server.
#
# Example:
# REQ_JAVA_HOME=/usr/local/j2sdk1.4.2
# REQ_APP_SERVER_HOME=/usr/local/apache-tomcat-5.5.12

REQ_JAVA_HOME=/usr/local/jdk
REQ_APP_SERVER_HOME=/usr/local/apache-tomcat-7.0.42

# --------------------------------------------------------------------------------


OLD_JAVA_HOME=$JAVA_HOME

export JAVA_HOME=$REQ_JAVA_HOME
export APP_SERVER_HOME=$REQ_APP_SERVER_HOME

echo "setting -- JAVA_HOME: $JAVA_HOME"
echo "====================================="

export JAVA_VERSION=`$JAVA_HOME/bin/java -version 2>&1 | head -1 | awk '{print $NF}' | tr -d \"`
echo "setting -- JAVA_VERSION: $JAVA_VERSION"

echo "building..."
ant all
echo "built..."

echo "unsetting temporary environment"
export JAVA_VERSION
export JAVA_HOME=$OLD_JAVA_HOME
echo "JAVA_HOME: $JAVA_HOME"
echo "====================================="
