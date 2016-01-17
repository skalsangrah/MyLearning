export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.65-3.b17.el7.x86_64/jre/

#HADOOP
export HADOOP_PREFIX=/home/hdu/hadoop/hadoop/
export PATH=$PATH:$HADOOP_PREFIX/bin
export PATH=$PATH:$HADOOP_PREFIX/sbin
export HADOOP_MAPRED_HOME=${HADOOP_PREFIX}
export HADOOP_COMMON_HOME=${HADOOP_PREFIX}
export HADOOP_HDFS_HOME=${HADOOP_PREFIX}
export YARN_HOME=${HADOOP_PREFIX}

#HIVE
export HIVE_HOME=/home/hdu/hive
export PATH=$PATH:$HIVE_HOME/bin

#PIG
export PIG_HOME=/home/hdu/pig/
export PATH=$PATH:$PIG_HOME/bin

