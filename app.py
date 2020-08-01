import flask
import tensorflow as tf
import numpy as np
from keras.preprocessing.image import ImageDataGenerator
from keras.preprocessing import image
import cv2
import time
import json
a=[]

tf.__version__

app = flask.Flask(__name__)
@app.route('/', methods=['GET', 'POST'])
def handle_request():
    return o

# Part 1 - Data Preprocessing

   

# Preprocessing the Training set

train_datagen = ImageDataGenerator(rescale = 1./255,
                                   shear_range = 0.2,
                                   zoom_range = 0.2,
                                   horizontal_flip = True)
training_set = train_datagen.flow_from_directory('F:/Machine-Learning-A-Z-Template-Folder/Part 8 - Deep Learning/Section 40 - Convolutional Neural Networks (CNN)/trafficnet_dataset_v1/train',
                                                 target_size = (64, 64),
                                                 classes=['dense_traffic','sparse_traffic'],
                                                 batch_size = 32)

# Preprocessing the Test set
test_datagen = ImageDataGenerator(rescale = 1./255)
test_set = test_datagen.flow_from_directory('F:/Machine-Learning-A-Z-Template-Folder/Part 8 - Deep Learning/Section 40 - Convolutional Neural Networks (CNN)/trafficnet_dataset_v1/test',
                                            target_size = (64, 64),
                                            classes=['dense_traffic','sparse_traffic'],
                                            batch_size = 32)
                                            
# Part 2 - Building the CNN

# Initialising the CNN
cnn = tf.keras.models.Sequential()

# Step 1 - Convolution
cnn.add(tf.keras.layers.Conv2D(filters=32, kernel_size=3, activation='relu', input_shape=[64, 64, 3]))

# Step 2 - Pooling
cnn.add(tf.keras.layers.MaxPool2D(pool_size=2, strides=2))

# Adding a second convolutional layer
cnn.add(tf.keras.layers.Conv2D(filters=32, kernel_size=3, activation='relu'))
cnn.add(tf.keras.layers.MaxPool2D(pool_size=2, strides=2))

# Step 3 - Flattening
cnn.add(tf.keras.layers.Flatten())

# Step 4 - Full Connection
cnn.add(tf.keras.layers.Dense(units=128, activation='relu'))

# Step 5 - Output Layer
cnn.add(tf.keras.layers.Dense(units=2, activation='sigmoid'))

# Part 3 - Training the CNN

# Compiling the CNN
cnn.compile(optimizer = 'adam', loss = 'binary_crossentropy', metrics = ['accuracy'])

# Training the CNN on the Training set and evaluating it on the Test set
cnn.fit(x = training_set, validation_data = test_set, epochs = 5)
high=0
low=0
e=0
f=0
u=[]
v=[]
cap= cv2.VideoCapture('F:\\Machine-Learning-A-Z-Template-Folder\\Part 8 - Deep Learning\\Section 40 - Convolutional Neural Networks (CNN)\\trafficnet_dataset_v1\\Videos\\sample.mp4')
noframes=cap.get(cv2.CAP_PROP_FPS)
while(cap.isOpened()):
    ret, frame = cap.read()
    if ret == False:
        break
    cv2.imwrite('frame1.jpg',frame)
    test_image = image.load_img('frame1.jpg', target_size = (64, 64))
    test_image = image.img_to_array(test_image)
    test_image = np.expand_dims(test_image, axis = 0)
    result =cnn.predict(test_image)
    training_set.class_indices
    if result[0][0] ==1:
        prediction =True
        high+=1
    else:
        prediction =False
        low+=1
    h=high/noframes
    l=low/noframes
    i=0
    if(h+l==1):
        if(h>l):
            x=True
        else:
            x=False
        e=e+h
        f=f+l
        if(e+f==60):
            u.append(e)
            v.append(f)
            e=0
            f=0
        high=0
        low=0
        a.append(x)
o=json.dumps(a)
cap.release()
cv2.destroyAllWindows()
app.run(host="0.0.0.0", port=5000)
    

























