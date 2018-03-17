#! /bin/sh
# Description: Script for configuring a program as a service

#----------------------------------------------------------------------
# Update sysconfig and install app as a service
#----------------------------------------------------------------------
# Make sure only root can run this script

if [ $EUID -ne 0 ]; then
   echo "ERROR: This script must be run as root" 1>&2
   exit 1
fi

SERVICE_NAME=eagle-client

SERVICE_PIDFILE=/var/run/${SERVICE_NAME}/${SERVICE_NAME}.pid
SERVICE_LOCKFILE=/var/lock/${SERVICE_NAME}/${SERVICE_NAME}
SERVICE_LOGFILE=/var/log/${SERVICE_NAME}/${SERVICE_NAME}.log

BASE_DIR="$(cd $(dirname $0); pwd)"
HOME_DIR="$(cd $BASE_DIR/..; pwd)"
SYSCONFIG_SRC_DIR="$HOME_DIR/etc/sysconfig"
SYSCONFIG_INSTALL_DIR=/etc/sysconfig
INIT_SRC_DIR="$HOME_DIR/etc/init.d"
INIT_INSTALL_DIR=/etc/init.d


if [ -z "$SERVICE_NAME" ]; then
	echo "ERROR: Service name not given" 1>&2
	exit 1
fi
if ! [ -f "$INIT_SRC_DIR/$SERVICE_NAME" ]; then
	echo "ERROR: $INIT_SRC_DIR/$SERVICE_NAME not found" 1>&2
	exit 1
fi
if ! [ -f "$SYSCONFIG_SRC_DIR/$SERVICE_NAME" ]; then
	echo "ERROR: $SYSCONFIG_SRC_DIR/$SERVICE_NAME not found" 1>&2
	exit 1
fi

echo "Installing configuration file..."
cp -pf "$SYSCONFIG_SRC_DIR/$SERVICE_NAME" "$SYSCONFIG_INSTALL_DIR/"
sed -i -e "s|#SERVICE_HOME=$|SERVICE_HOME=\"${HOME_DIR}\"|" -e "s|#SERVICE_PIDFILE=$|SERVICE_PIDFILE=\"${SERVICE_PIDFILE}\"|" -e "s|#SERVICE_LOCKFILE=$|SERVICE_LOCKFILE=\"${SERVICE_LOCKFILE}\"|" -e "s|#SERVICE_LOGFILE=$|SERVICE_LOGFILE=\"${SERVICE_LOGFILE}\"|" "$SYSCONFIG_INSTALL_DIR/$SERVICE_NAME"
echo "Done"

echo
echo "Installing service file..."
cp -pf "$INIT_SRC_DIR/$SERVICE_NAME" "$INIT_INSTALL_DIR/"
sed -i "s|^# pidfile:$|# pidfile: ${SERVICE_PIDFILE}|" "$INIT_INSTALL_DIR/$SERVICE_NAME"
chkconfig --add $SERVICE_NAME
echo "Done"

echo
echo "Adding service to system startup..."
chkconfig $SERVICE_NAME on
echo "Done"
#----------------------------------------------------------------------
