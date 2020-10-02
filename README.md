# AppliProjetInterfilliere
application android connectée a un robot Pepper

connection du server taper :

import socket

connection = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

connection.bind(('',1555))

connection.listen(5)

connection_client , info_connection = connection.accept()

