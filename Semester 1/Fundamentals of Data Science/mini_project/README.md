

# <center> Fundamentals of Data Science Mini Project </center>



## <center> Analysis of Mall Customers dataset </center>

----

#### Implementation details:

1. ***Build platform*** : [Python3 v3.9.8 (64 bit)](https://www.python.org/downloads/release/python-398/) on Windows 10 Home Edition.

2. ***Target platform*** : Any operating system capable of running Python3 v3.6+.

3. ***File format*** : IPython Notebook File (.ipynb)

4. ***System packages used*** : None

5. ***Additional packages used*** : [`matplotlib`](https://matplotlib.org/), [`numpy`](https://numpy.org/), [`pandas`](https://pandas.pydata.org/), [`notebook` (For classic notebook UI) or `jupyterlab`(For a more IDE based look)](https://jupyter.org/)
   + If you are new to Python, then you can use the [Anaconda](https://www.anaconda.com/) distribution. It contains a lot of the most popular data science packages (including the ones listed above) preinstalled with a working Python Environment.
   
   + For more advanced users (or those familiar with `pip`), this command should install all necessary packages: 
   
     ```shell
     pip install --user numpy scipy matplotlib ipython jupyter pandas sympy nose
     ```
   
     **Note:** Replace `pip` with `pip3` if you are using Linux or MacOS.
   
     
   
     This should also install [`scipy`](https://scipy.org/),  a free and open-source library used for scientific computing and technical computing along with [`sympy`](https://www.sympy.org/), a library used for symbolic mathematics and [`nose`](https://nose.readthedocs.io/en/latest/), a powerful testing framework.
   
   - You can also use your OS package manager to install these packages. Please check your OS-specific packager manager for installation instructions.



#### File details:

1. Source file : [mini_project.ipynb](mini_project.ipynb)
2. Source file (as PDF) : [FDS Mini Project(015).pdf](FDS Mini Project(015).pdf)
3. Dataset used : [data_sets/Mall_Customers.csv](data_sets/Mall_Customers.csv)
4. Dataset Source : [Kaggle](https://www.kaggle.com/vjchoudhary7/customer-segmentation-tutorial-in-python)



## <center> Concepts used </center>

### <center> Histogram </center>

> A **histogram** is an approximate representation of the [distribution](https://en.wikipedia.org/wiki/Frequency_distribution) of numerical data. It was first introduced by [Karl Pearson](https://en.wikipedia.org/wiki/Karl_Pearson). "[bin](https://en.wikipedia.org/wiki/Data_binning)" (or "[bucket](https://en.wikipedia.org/wiki/Data_binning)") the range of values—that is, divide the entire range of values into a  series of intervals—and then count how many values fall into each  interval.  The bins are usually specified as consecutive,  non-overlapping [intervals](https://en.wikipedia.org/wiki/Interval_(mathematics)) of a variable. The bins (intervals) must be adjacent and are often (but not required to be) of equal size. \- [Wikipedia](https://en.wikipedia.org/wiki/Histogram)



### <center> Pivot tables </center>

> A **pivot table** is a [table](https://en.wikipedia.org/wiki/Table_(information)) of grouped values that aggregates the individual items of a more extensive table (such as from a [database](https://en.wikipedia.org/wiki/Database), [spreadsheet](https://en.wikipedia.org/wiki/Spreadsheet), or [business intelligence program](https://en.wikipedia.org/wiki/Business_intelligence_software)) within one or more discrete categories. This summary might include sums, averages, or other statistics, which the pivot table groups together using a chosen aggregation function applied to the grouped values. \- [Wikipedia](https://en.wikipedia.org/wiki/Pivot_table)



### <center> Conditional probability </center>

> In [probability theory](https://en.wikipedia.org/wiki/Probability_theory), **conditional probability** is a measure of the [probability](https://en.wikipedia.org/wiki/Probability) of an [event](https://en.wikipedia.org/wiki/Event_(probability_theory)) occurring, given that another event (by assumption, presumption, assertion or evidence) has already occurred. If the event of interest is *A* and the event *B* is known or assumed to have occurred, "the conditional probability of *A* given *B*", or "the probability of *A* under the condition *B*", is usually written as P(*A*|*B*) or occasionally P<sub>*B*</sub>(*A*). This can also be understood as the fraction of probability B that intersects with A:
> $$
> P(A|B) = \frac{P(A \cap B)}{P(B)}
> $$
> \- [Wikipedia](https://en.wikipedia.org/wiki/Conditional_probability)

