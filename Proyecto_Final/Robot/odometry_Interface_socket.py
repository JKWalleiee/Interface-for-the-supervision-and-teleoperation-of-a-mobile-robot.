#!/usr/bin/env python
import roslib
import rospy
import geometry_msgs.msg
import socket, pickle
import json
#VERSION FINAL
from nav_msgs.msg import Odometry
a = 1
def odometryCb(msg):
     global a
     
     
     
     #data = s.recv(1024)
     #print "1)", data
     a = 0

     
     rospy.loginfo("X is %s", msg.pose.pose.position.x)
     rospy.loginfo("Y is %s", msg.pose.pose.position.y)
          
     arr =  msg.pose.pose.position.x
     ant =  msg.pose.pose.position.y
     	
		            
     data_string = json.dumps(arr)
     s.send(data_string+'\n')
		             
     data_string = json.dumps(ant)
     s.send(data_string+'\n')
     	#data = s.recv(1024)
     	#print "2)", data

     
    #print "position x" + msg.pose.pose.position.x

if __name__ == "__main__":
    rospy.init_node('oodometry', anonymous=True) #make node 
    HOST = 'localhost'
    PORT = 9090
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect((HOST, PORT))
    data = s.recv(1024)
    print "1)", data
    rospy.Subscriber('RosAria/pose',Odometry,odometryCb)
    rospy.spin()
else:
     	s.close()
