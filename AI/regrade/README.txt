Input: 
Takes 3 command line arguments
arg 1 - Path to train dataset
arg 2 - Path to test dataset
arg 3 - 0 or 1 (0 for information gain and 1 for depth control)

Output:
The tree is printed in words.
Each node is printed with its node id, level, question the node is split on, the value of the parent question, parent node id and 
the number of children. For a leaf node, additionaly the predicted class name is also specified. 
Following this will keep track of the structure of the tree.
After this, the performance of on the test dataset is printed. False positive, false negative, true positive and true negative vales are printed.

The code contains the implementaion of decision tree using two strategies.
Information Gain: At every node, the splitting is done on the column with highest gain. The gain is calculated using entropy and node impurity.
In simple terms, the split is done on the column that leads to the highest pure nodes. The working is explained in the textbook.
Depth Control: The basic idea of this strategy is to control the depth of the decision tree at every level. The idea is to choose to split on the 
attribute which will result in more number of child nodes. I think this will help in evenly distributing the data to all the child nodes and 
also in reducing the height of the tree. So the pre-processing step involves ranking every column and ranking it. 
The rank is given on  the basis of unique elements a column contains. Higher the elements higher is the priority. 
While splitting the column is selected on the order of highest priority. This results in a wide tree thereby reducing the height solving 
the purpose of the idea.