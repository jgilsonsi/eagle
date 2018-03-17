#!/bin/sh
# Description: Startup script for a given binary

#----------------------------------------------------------------------
# Startup script for a given binary
#----------------------------------------------------------------------
SERVICE_NAME=eagle-client
SERVICE_CONFIG=/etc/sysconfig/$SERVICE_NAME
if ! [ -r "$SERVICE_CONFIG" ]; then
	echo "ERROR: File $SERVICE_CONFIG could not be read" 1>&2
	exit 1
fi
. "$SERVICE_CONFIG"

SERVICE_CMD="java -jar"
SERVICE_BIN="eagle-client.jar"

BASE_DIR="$(cd $(dirname $0); pwd)"
HOME_DIR="$(cd $BASE_DIR/..; pwd)"


eval_params() {
	retval=0
	for i in $1; do
		param=$(eval "printf \$$i" 2>/dev/null)
		test -n "${param}" && params="$params \"$param\"" && continue
		echo "ERROR: Parameter $i is empty" 1>&2
		retval=1
	done
	return $retval
}


if ! [ -f "$SERVICE_HOME/$SERVICE_BIN" ]; then
	echo "ERROR: $SERVICE_HOME/$SERVICE_BIN not found" 1>&2
	exit 1
fi
if [ -z "$SERVICE_NAME" ]; then
	echo "ERROR: Service name not given" 1>&2
	exit 1
fi
if [ -z "$SERVICE_PIDFILE" ]; then
	echo "ERROR: Service pid file not given" 1>&2
	exit 1
fi
if [ -z "$SERVICE_LOGFILE" ]; then
	echo "ERROR: Service log file not given" 1>&2
	exit 1
fi

test -r $BASE_DIR/service_override && . $BASE_DIR/service_override
declare -f get_params >/dev/null && get_params

cd $HOME_DIR
eval "$SERVICE_CMD $SERVICE_BIN $params >> $SERVICE_LOGFILE 2>&1 &"
service_pid=$!
echo $service_pid > $SERVICE_PIDFILE
#----------------------------------------------------------------------
