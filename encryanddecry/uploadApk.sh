\#!/bin/sh
\#MAIN_MODULE指AndroidStudio工程目录下面主module
MAIN_MODULE="."
\#蒲公英API账号

PGYER_API_KEY="xxxxx"
PGYER_USER_KEY="xxxxxx"
\#APK路径
APK_PATH="${MAIN_MODULE}/build/outputs/apk"
echo "current path: `pwd`"
\#遍历apk，选出今天生成的apk，有多个的话，选出第一个
TODAY=`date +%Y-%m-%d`
echo "Today is $TODAY"
for APK_FILE in ${APK_PATH}/*; do
    APK_NAME=`basename $APK_FILE`
    if [[ "$APK_NAME" =~ "$TODAY.apk" ]];then
        echo "上传的apk名称:$APK_NAME"
        break
    fi
done
\#curl上传至蒲公英，默认直接发布，不发布到广场
curl -F "file=@${APK_PATH}/${APK_NAME}" -F "uKey=${PGYER_USER_KEY}" -F "_api_key=${PGYER_API_KEY}" http://www.pgyer.com/apiv1/app/upload