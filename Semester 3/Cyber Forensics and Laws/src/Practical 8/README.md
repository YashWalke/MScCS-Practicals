# <center>Practical 8</center>
---
**<u>Aim:</u>** Retrieve deleted files from a computer.


**<u>Procedure:</u>**
+ Download and install `Autopsy`® from this [link](https://www.autopsy.com/download/). Running the application should present you this window:

![Welcome Screen](../../screenshots/Practical%208/screenshot-1.PNG)


+ Click on `New Case`. It should present you this window asking for case name and 
the directory to store case-related data.

![Case Information (Required)](../../screenshots/Practical%208/screenshot-2.PNG)


+ Enter the relevant details and click on `Next`. A new section will be available which will ask you to fill in optional information. You *may* choose to not enter any information in this section. Click `Finish` when you're done.

![Case Information (Optional)](../../screenshots/Practical%208/screenshot-3.PNG)


+ A new window titled "Add Data Source" should now be visible. If it does not appear automatically, you can manually open it using the relevant toolbar item. Select "Local Disk" as the type of data source to be added and click on `Next`.

![Add Data Source Type](../../screenshots/Practical%208/screenshot-4.PNG)


+ A new section named "Select Data Source" should now be active. Select the disk of your choice and click on `Next`.

![Select Data Source](../../screenshots/Practical%208/screenshot-5.PNG)


+ You can use the default options in the "Configure Ingest Modules" section. After which, the data source will be added to the case database.

![Configure Ingest Modules](../../screenshots/Practical%208/screenshot-6.PNG)

![Data Source Addition complete](../../screenshots/Practical%208/screenshot-7.PNG)


+ Autopsy® will now try to process the data source. This process may take some time depending on the size of the disk and its contents. After completion, you will see all the information it has gathered ordered as a tree. Now, navigate to `Data Sources > {Disk of your choice} > $OrphanFiles`. It will show all the deleted files. You can retrieve it by right clicking the file(s) and selecting `Export`. It will ask for a location to restore the file.

![Deleted files](../../screenshots/Practical%208/screenshot-8.PNG)


+ To generate a report, click the `Generate Report` toolbar item. It should open a 'Generate Report' wizard. Select the type of report you want and click on `Next`.

![Generate report](../../screenshots/Practical%208/screenshot-9.PNG)


+ Select the data sources to be included and click on `Next`.

![Select Data Sources](../../screenshots/Practical%208/screenshot-10.PNG)


+ Select the data which should be reported and click on `Finish`. The report will be generated.

![Reported Data](../../screenshots/Practical%208/screenshot-11.PNG)

![Report Generation](../../screenshots/Practical%208/screenshot-12.PNG)