# simplemedicinedb
 A "DEMO" medicine prescription platform 

::End points are::

    @PostMapping("/add/")
    
   	@GetMapping("/prescriptions")
  
Get request over path /prescriptions?phone=  
here, this phone is the unique identifier of the person whose prescriptions are to be retrieved.
  <br>
Post request over path /add/ requires a person object (in default-supported-forms like json, xml, etc.)... eg.  <br>
<br>
{<br>
<br> "
<br> "phone":1234567890, /**this is phone number of 10  digits, must be sent.*/
<br> "name":"patient (monty)", /**this is name of person, must be sent*/
 <br>"prescribed_medicines": [ /**This is list of prescribed medicines*/
   <br>     
   {   <br>    
  <br>   "dosage_amount": 2000, /** This is amount needed to be taken by a person*/
    <br>  "timings": "before wake-up", /** this is timings of when to be taken*/
     <br> "md":{
 <br>   "name":"test Medicine", /** this is name of medicine*/
      <br>  	"mfg_By":"l rights", /** this is name of manufacturing company*/
       <br>  "mktd_By":"VENR 2",   /**this is the name of marketing company*/
       <br> 	"chemicals":"Unknowm",  /**this is the name of chemical composition in medicine*/
        <br>  "any_other_note":"Not for the time being" /**this is optional note*/
      }<br>
   }<br>
 ]<br>
}<br>
<br>
Above is explanation of all fields.... To use a sample, look at sample_input.txt file.
