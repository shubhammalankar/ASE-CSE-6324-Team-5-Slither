# ASE-CSE-6324-Team-5-Slither

Iteration 1

1. Shubham Arun Malankar<br>
2. Nageshwar Ramkumar Jaiswal<br>
3. Ravi Prakasha<br>
4. Navyashree Budhihal Mutt<br>
5. Rushikesh Mahesh Bhagat<br>

# Steps to run and test the code
1. Please install the latest version of [Python](https://www.python.org/downloads/)<br> 
2. Install the git from [site](https://git-scm.com/download/)<br>
3. Next, clone the [repository](https://github.com/trailofbits/slither) and extract the file folder by using the following command. <br>
4. Create a virtual environment inside the folder where the slither code resides by following the below command in the terminal  <br>
```python3 -m venv env``` <br>
5. To activate virtual environment in the folder: <br>
-On Windows: ```cd env\Scripts\activate.bat``` <br>
-On macOS/Linux: ```virtualenv env```<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;```source env/bin/activate``` <br>
6. Install the following dependencies using the pip command from the terminal . <br>
-Python version - 3.9.7<br>
-Cbor2 - 5.4.6<br>
-crytic-compile - 0.3.0 <br>
-Jellyfish - 0.9.0<br>
-Packaging - 23.0<br>
-Prettytable - 3.6.0<br>
-Pycryptodome - 3.17<br>
-slither-analyzer==0.9.2<br> 
-snakeviz==2.1.1<br>
-solc-select==1.0.3<br>
-tornado==6.2<br>
-wcwidth==0.2.6<br>
7. After installing the dependencies navigate to the slither folder inside the folder from the terminal<br>	 
-On Windows: ```cd slither```<br>
-On macOS/Linux: ```cd/slither```<br>
8. Run the below command<br>
```python -m cProfile -o slithe_results -s tottime -m slither GovernorSettings.sol```<br> 
9. After running the above command then run below the command<br>
```snakeviz slithe_results```<br>
The graphical results will automatically open in the browser available on the computer. 
