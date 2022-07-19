# <center>Practical 9</center>
---
**<u>Aim:</u>** Use the registry to obtain information.

**<u>Theory:</u>**
The Windows Registry Editor was launched in 1992 with Microsoft Windows 3.1. The registry is the backbone of the OS and is critical for system performance. It enables administrators and advanced users to keep the registry operational and make root and administrative level changes such as setting up access permissions or changing the hardware and software level configuration.

**Features:**
1. System Performance:
	+ If a key inside the registry becomes corrupt or faulty, it can cause system to crash or other performance issues.
	+ Using Registry Editor we can edit/update the key.
2. Configuration settings:
	+ The automatic type startup programs display or desktop setting can be configured using regedit.
3. Registry cleaning:
	+ Entries inside the registry can sometimes break. To fix broken entries, a registry cleaner is required.
	+ Unlike standard config files, entries inside the Registry cannot be opened or cleaned via standard text editor.
4. Registry errors:
	+ Certain events can disturb the hierarchy and cause errors.
	+ The regedit tool can be used to fix the hierarchical structure of the registry.
5. Finding Strings:
	+ regedit can be helpful when searching for specific strings in keys, values (names & values).
6. Remote editing of registry:
	+ regedit can be used for remote editing of another computer's registry on the same network.
7. Modification of key:
	+  Registry key can be modified, renamed or deleted by regedit.

**<u>Steps:</u>**

+ Press Windows key + R to access the `Run...` command.

![Run command](../../screenshots/Practical%209/screenshot-1.png)

+ Type regedit and press [`Enter`].

![Registry Editor](../../screenshots/Practical%209/screenshot-2.png)



**<u>Locations:</u>**
+ Wireless Evidences: `Computer\HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows NT\CurrentVersion\NetworkList\Profiles`

![Wireless Evidences](../../screenshots/Practical%209/screenshot-3.png)


+ Recent Documents key:
`Computer\HKEY_CURRENT_USER\SOFTWARE\Microsoft\Windows\CurrentVersion\Explorer\RecentDocs`

![Recent Documents](../../screenshots/Practical%209/screenshot-4.png)


+ Typed <abbr title = "Universal Resource Locator">URL</abbr>'s key:
`Computer\HKEY_CURRENT_USER\SOFTWARE\Microsoft\Internet Explorer\TypedURLs`

![Typed URLs](../../screenshots/Practical%209/screenshot-5.png)


+ <abbr title = "Internet Protocol">IP</abbr> address:
`Computer\HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\Tcpip\Parameters\Interfaces`

![IP address](../../screenshots/Practical%209/screenshot-6.png)


+ Startup applications:
`Computer\HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows\CurrentVersion\Run`

![Startup applications](../../screenshots/Practical%209/screenshot-7.png)


+ Startup services:
`Computer\HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services`

![Startup services](../../screenshots/Practical%209/screenshot-8.png)


+ Start legacy applications:
`Computer\HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\WDI`

![Start legacy applications](../../screenshots/Practical%209/screenshot-9.png)


+ Startup application(s) when a particular user logs in:
`Computer\HKEY_CURRENT_USER\SOFTWARE\Microsoft\Windows\CurrentVersion\Run`

![Curent user's startup applications](../../screenshots/Practical%209/screenshot-10.png)


+ <abbr title = "Universal Serial Bus">USB</abbr> drives:
`Computer\HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Enum\USB`

![USB drives](../../screenshots/Practical%209/screenshot-11.png)


+ Mounted devices:
`Computer\HKEY_LOCAL_MACHINE\SYSTEM\MountedDevices`

![Mounted Devices](../../screenshots/Practical%209/screenshot-12.png)