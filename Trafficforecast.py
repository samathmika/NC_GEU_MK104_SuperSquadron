import sqlite3
from sqlite3 import Error
import numpy as np
import io
import matplotlib.pyplot as plt
import flask
import json

app = flask.Flask(__name__)
@app.route('/stats', methods=['GET', 'POST'])
def handle_request():
    return o

def create_connection(db_file):
    """ create a database connection to a SQLite database """
    conn = None
    try:
        conn = sqlite3.connect(db_file)
        print(sqlite3.version)
    except Error as e:
        print(e)
    finally:
        if conn:
            conn.close()
if __name__ == '__main__':
    create_connection("highlow.db")
    
conn = sqlite3.connect("highlow.db")
print(sqlite3.version)

arr1=np.array(arr1)
arr2=np.array(arr2)
t=np.array(t)

z=[[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0]]

a=[arr1,arr2]
a=np.array(a)

for i in range(len(a)):
   # iterate through columns
   for j in range(len(a[0])):
       z[j][i] = a[i][j]
     
z=np.array(z) 

from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(z,t, test_size = 0.2, random_state = 0)

from sklearn.linear_model import LinearRegression
regressor = LinearRegression()
regressor.fit(X_train, y_train)


# Predicting the Test set results
y_pred =regressor.predict(X_test)

def adapt_array(arr):
    out = io.BytesIO()
    np.save(out, arr)
    out.seek(0)
    return sqlite3.Binary(out.read())


def convert_array(text):
    out = io.BytesIO(text)
    out.seek(0)
    return np.load(out)

# Converts np.array to TEXT when inserting
sqlite3.register_adapter(np.ndarray, adapt_array)

# Converts TEXT to np.array when selecting
sqlite3.register_converter("array", convert_array)

con = sqlite3.connect(":memory:", detect_types=sqlite3.PARSE_DECLTYPES)
cur = con.cursor()

cur.execute("CREATE TABLE HL1(arr1  array,arr2 array,t array);")
print ("Table created successfully")
cur.execute("INSERT INTO HL1(arr1,arr2,t)VALUES(?,?,?)",(arr1,arr2,t))
conn.commit()
var='''SELECT * FROM HL1'''
cur.execute(var)

rows = cur.fetchall()
app.run(host="0.0.0.0", port=5000)
