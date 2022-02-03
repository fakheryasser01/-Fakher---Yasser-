# LinkedIn TestCases 
Test cases "BVT" for LinkedIn

##Feature : Sign up with Email
### TestCases
    * Verify that the  user can sign up with valid user credentials "Email / password /phone"
    * Verify that the  user can't Sign up with invalid user email 
    * Verify that the  user can't Sign up with invalid user password
    * Verify that the  user can't Sign up with invalid user phone
    * Verify that the  user can't Sign up if select uncorrect verficiation image 
    * Verify that the  sign up process start from the beginning if the app is closed in any stage of sign up process 


_______________________________________________________________________________


- **TestCase ID :** 1          ||       **TestCase Priority :** High
- **TestCase Name :** Verify that the user can sign up with valid email
- **Description :**  Sign up with a valid email
- **State :** Design
- **Design By :**  Fakher Yasser    |    **Design Date :** 30/1/2022
- **Executed By :** ----           |**Executed Date :**  ----
- **Area :**  LinkedIn - Android                   | **Iteration :** LinkedIn - Sprint 1


- **PreCondition :** 
  * A valid email created
  * LinkedIn App downloaded 
- **Test Data :**
  * valid email  : Fakherqa@gmail.com
  * Password : hiqa12345
  * first Name  : fakher
  * last Name : yasser
  *   Country : Egypt 
  * phone number : 1122334488
* **Test Steps :**
  * Open LinkedIn App 
  * Enter email and click on continue Button
  * Enter password and click on continue Button
  * Enter first name and last Name  and click on Agree&Join Button
  * Enter phone number and click on submit Button
  * Copy/Paste verification code and click on Submit Button
  * Click on verify  and select the correct image  and check 
  
- **Expected results  :**
   * The LinkedIn App is opened
   * The password page is opened 
   * The first name and last name page is opened 
   * The verification phone number page is opened
   * The verification code page is opened
   * The recaptcha page is opened 
   * The user Sign up with email successfully and will be asked for enter more data 

_______________________________________________________________________________
- **TestCase ID :** 2          ||       **TestCase Priority :** High
- **TestCase Name :** Verify that the  user can't Sign up with invalid user email
- **Description :** user can't Sign up with an invalid email
- **State :** Design
- **Design By :**  Fakher Yasser    |    **Design Date :** 30/1/2022
- **Executed By :** ----           |**Executed Date :**  ----
- **Area :**  LinkedIn - Android                   | **Iteration :** LinkedIn - Sprint 1


- **PreCondition :**
    * LinkedIn App downloaded


- **Test Data :**
    * valid email address : Fakherqa@gmail.


* **Test Steps :**
    * Open LinkedIn App
    * Enter the invalid email , click on continue Button and check

- **Expected results  :**
    * Open LinkedIn App
    * The invalid email/phone message appears to the user 

_______________________________________________________________________________
- **TestCase ID :** 3        ||       **TestCase Priority :** Medium
- **TestCase Name :** Verify that the signup process start from the beginning if the app is closed in any stage of sign up process


- **Description :** user can't Sign up with an invalid email
- **State :** Design
- **Design By :**  Fakher Yasser    |    **Design Date :** 30/1/2022
- **Executed By :** ----           |**Executed Date :**  ----
- **Area :**  LinkedIn - Android                   | **Iteration :** LinkedIn - Sprint 1


- **PreCondition :**
  * LinkedIn App downloaded


- **Test Data :**
  * valid email address : Fakherqa@gmail.com
  * Password : hiqa12345

* **Test Steps :**
  * Open LinkedIn App
  * Enter email and click on continue Button
  * Enter password and click on continue Button
  * put app on the device background and close it 
  * Reopen the LinkedIn app  

- **Expected results  :**
  * The LinkedIn App is opened
  * The password page is opened
  * The first name and last name page is opened 
  * The app is closed 
  * The app must open from thr beginning of the signup process 
_________________________________________________________________________________________________

##Feature : Sign up with Gmail
### TestCases
    * Verify that the  user can sign up using Gmail with valid user credentials "password/ phone number"
    * Verify that the  user can't Sign up using Gmail with invalid user password
    * Verify that the  user can't Sign up using Gmail with invalid user phone
    * Verify that the  user can't Sign up using Gmail if uncorrect verficiation code 
    * Verify that the  sign up process start from the beginning if the app is closed in any stage of sign up process
_________________________________________________________________________________________________
**TestCase ID :** 4         ||       **TestCase Priority :** High
- **TestCase Name :** Verify that the  user can sign up using Gmail with valid user credentials "password/ phone number"
- **Description :**  Sign up with Gmail with valid credentials 
- **State :** Design
- **Design By :**  Fakher Yasser    |    **Design Date :** 30/1/2022
- **Executed By :** ----           |**Executed Date :**  ----
- **Area :**  LinkedIn - Android                   | **Iteration :** LinkedIn - Sprint 1


- **PreCondition :**
  * A valid Gmail  created
  * LinkedIn App downloaded
- **Test Data :**
  * valid email  : Fakherqa@gmail.com
  * password :hi12345 
  * phone number : 1122334488
* **Test Steps :**
  * Open LinkedIn App
  * Click on Sign up with Gmail
  * Select an email / open Gmail and sign in to your email
  * Enter password and click on continue Button and check

- **Expected results  :**
  * The LinkedIn App is opened
  * The password page is opened
  * The Gmail user Sign up successfully 

_________________________________________________________________________________________________
**TestCase ID :** 5        ||       **TestCase Priority :** High
- **TestCase Name :** Verify that the  user can sign up using Gmail with valid user credentials "password/ phone number"
- **Description :**  Sign up with Gmail with valid credentials
- **State :** Design
- **Design By :**  Fakher Yasser    |    **Design Date :** 30/1/2022
- **Executed By :** ----           |**Executed Date :**  ----
- **Area :**  LinkedIn - Android                   | **Iteration :** LinkedIn - Sprint 1


- **PreCondition :**
  * A valid Gmail  created
  * LinkedIn App downloaded
- **Test Data :**
  * valid email  : Fakherqa@gmail.com
  * invalid password : hi 
  * phone number : 1122334488
* **Test Steps :**
  * Open LinkedIn App
  * Click on Sign up with Gmail
  * Select an email / open Gmail and sign in to your email
  * Enter password and click on continue Button and check

- **Expected results  :**
  * The LinkedIn App is opened
  * The password page is opened
  * The invalid password message appears to the user 
________________________________________________________________________________
  
##Feature : Sign In with Email
### TestCases
    * Verify that the  user can sign In with regiestered user credentials "Email / password " 
    * Verify that the  user can't Sign in with invalid user email 
    * Verify that the  user can't Sign in with not exists user email
    * Verify that the  user can't Sign in with invalid user password
    * Verify that the  user can't Sign in with invalid user email and password

_______________________________________________________________________________

##Feature : Sign In with Gmail
### TestCases
    * Verify that the  user can sign In with regiestered user credentials "Email"
    * Verify that the  user can't Sign in with not exists user email


_______________________________________________________________________________

##Feature : Home page 
### TestCases
    * Verify that the Ui of the Home page is applied as required on many devices "Tablets / phones"
    * Verify that the user can find message icon and can open it
    * Verify that the user can find profile icon and can open it
    * Verify that the user can find the menu bar with the required items 
    * Verify that the Home page load successfully
    * Verify that the disconnected empty view appears if there is no network
    * Verify that the user can find posts on the home page
    * Verify that the user can find the posts which liked by users he/she followed
    * Verify that every post contains "creator profile/ more options icon /Text or image or link / like Btn /comment/Share / Send "
    * Verify that the user can scroll down on the home page 
    * Verify that the pagination happens when scroll down and retrieve new posts  
    * Verify that the user can pull to refresh the Home page
    * Verify that the user can find Open the full post view by clicking on it 
    * Verify that the user can interact with emotion with the post 
    * Verify that the user can comment on the post
    * Verify that the user can share  the post
    * Verify that the user can send the post
     * Verify that the user can search by clicking on the search bar 

_______________________________________________________________________________
- **TestCase ID :** 6          ||       **TestCase Priority :** High
- **TestCase Name :** Verify that the Home page load successfully
- **Description :**  Home page must loaded successfully 
- **State :** Design
- **Design By :**  Fakher Yasser    |    **Design Date :** 30/1/2022
- **Executed By :** ----           |**Executed Date :**  ----
- **Area :**  LinkedIn - Android                   | **Iteration :** LinkedIn - Sprint 1


- **PreCondition :**
  * User already sign in 
  * User follow many users / companies before 
- **Test Data :**

* **Test Steps :**
  * Open LinkedIn App 
  * Check the home page

- **Expected results  :**
  * The LinkedIn App is opened
  * The Home page appears as required "Message , profile icons , menu bar and many posts appear "

_______________________________________________________________________________
- **TestCase ID :** 7        ||       **TestCase Priority :** High
- **TestCase Name :**   Verify that the pagination happens when scroll down and retrieve new posts
- **Description :**  check pagination load data 
- **State :** Design
- **Design By :**  Fakher Yasser    |    **Design Date :** 30/1/2022
- **Executed By :** ----           |**Executed Date :**  ----
- **Area :**  LinkedIn - Android                   | **Iteration :** LinkedIn - Sprint 1


- **PreCondition :**
  * User already sign in
  * User follow many users / companies before
- **Test Data :**

* **Test Steps :**
  * Open LinkedIn App
  * scroll down on the home page 

- **Expected results  :**
  * The LinkedIn App is opened
  * The loader appear on the bottom of the home page and load  data 


_______________________________________________________________________________
- **TestCase ID :** 8        ||       **TestCase Priority :** High
- **TestCase Name :**     Verify that the user can pull to refresh the Home page
- **Description :**  check pull to refresh load the newest data
- **State :** Design
- **Design By :**  Fakher Yasser    |    **Design Date :** 30/1/2022
- **Executed By :** ----           |**Executed Date :**  ----
- **Area :**  LinkedIn - Android                   | **Iteration :** LinkedIn - Sprint 1


- **PreCondition :**
  * User already sign in
  * User follow many users / companies before
- **Test Data :**

* **Test Steps :**
  * Open LinkedIn App
  * pull to refresh the home page

- **Expected results  :**
  * The LinkedIn App is opened
  * The loader appear on the top of the home page and load newest data 

_______________________________________________________________________________
- **TestCase ID :** 9       ||       **TestCase Priority :** High
- **TestCase Name :**   Verify that the user can interact with emotion with the post
- **Description :**  User can interact with the posts 
- **State :** Design
- **Design By :**  Fakher Yasser    |    **Design Date :** 30/1/2022
- **Executed By :** ----           |**Executed Date :**  ----
- **Area :**  LinkedIn - Android                   | **Iteration :** LinkedIn - Sprint 1


- **PreCondition :**
  * User already sign in
  * User follow many users / companies before
- **Test Data :**

* **Test Steps :**
  * Open LinkedIn App
  * long press on like button in the post "X"
  * select any emotion and check 

- **Expected results  :**
  * The LinkedIn App is opened
  * The all emotions appear 
  * The emotion is selected and appears on the post
_______________________________________________________________________________
- **TestCase ID :** 10       ||       **TestCase Priority :** Medium
- **TestCase Name :**   Verify that the user can find the posts which liked by users he/she followed
- **Description :**  User can find a posts like by other users 
- **State :** Design
- **Design By :**  Fakher Yasser    |    **Design Date :** 30/1/2022
- **Executed By :** ----           |**Executed Date :**  ----
- **Area :**  LinkedIn - Android                   | **Iteration :** LinkedIn - Sprint 1


- **PreCondition :**
  * User already sign in
  * User follow many users / companies before
- **Test Data :**

* **Test Steps :**
  * Open LinkedIn App
  * in The home page : scroll down to the see more posts and check 

- **Expected results  :**
  * The LinkedIn App is opened
  * The posts which liked by other users, he/she followed
  ________________________________________________________________________________

##Feature : Create Post 
### TestCases

    * Verify that the user can Open create post page by clicking on Post icon on the menu bar 
    * Verify that the Ui of the create post page is applied as required on many devices "Tablets / phones"
    * verify that there are many options "Add photo / video .. etc "appear to the user when opening create post page
    * Verify that the user can write a post in the text area
    * Verify that the keypad is opened when the clicking in text area  
    * Verify that the post button is disabled if the text area is empty 
    * Verify that the post button is disabled if the text area is filled with spaces
    * Verify that the visiblity of the post is appeared 
    * Verify that the user can change the visibilty of the post 
    * Verify that the user can post the post by clicking on the post icon after writing any char
    * Verify that the user can find the post after posting in the Home page
    * Verify that the user can find the post after posting in the  profil page


________________________________________________________________________________

##Feature : User Profile 
### TestCases

    * Verify that the user can Open the profile fom the home page by clicking on profile icon then click on view profile 
    * Verify that the user profile sections are appeared as required on the Ui 
    * verify that the user can edit intro by clicking on edit button 
    * Verify that the user can create a post from activity section in his 
    * Verify that the user can add experience to his profile 
    * Verify that the user can edit experience from his profile
    * Verify that the user can add education to his profile
    * Verify that the user can edit education from his profile
    * Verify that the user can add Skills to his profile
    * Verify that the user can edit skills from his profile
    * Verify that the user can add sections to his profile 

________________________________________________________________________________


##Feature : My Network Page
### TestCases
    * Verify that the user can Open "My network" page by clicking on My network icon on the menu bar
    * Verify that the user can find manage my network section 
    * verify that the user can scroll down to the end of the page 
    * Verify that the user can connect another user directly 
    * Verify that the user can follow another user directly 
    * Verify that the user can follow  company directly 
    * Verify that the user can find connections and Groups .. etc on th manage my network  


________________________________________________________________________________



##Feature : Jobs Page
### TestCases
    * Verify that the user can Open "Jobs" page by clicking on Jobs icon on the menu bar
    * Verify that the user can find "My Jobs" section if has a saved/applied jobs
    * verify that the user can find recent searche if the user searched before
    * Verify that the user can find a recommeded jobs section
    * Verify that the user can click on any job and open it 
    * Verify that the user can apply to job from my jobs page 
    * Verify that the user can search on job using the search bar 

________________________________________________________________________________



##Feature : Messaging Page
### TestCases
    * Verify that the user can Open "messaging" page by clicking on message icon on the header from any page 
    * Verify that the user can start new message by clicking on start message button and select user 
    * verify that the user can send message from the chat view 
    * Verify that the message can contains words / images 
    * Verify that the message icon has red dot when there is a new message
    * Verify that a notification appear to the user when he recived a message 
