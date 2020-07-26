# simplemedicinedb
 A "DEMO" medicine prescription platform 

::End points are::

    @PostMapping("/add/")
    
   	@GetMapping("/prescriptions")
  
Get request over path /prescriptions?person_id=  
here, this person_id is the id of the person whose prescriptions are to be retrieved. person_id id the request parameter.
  
Post request over path /add/ requires a person object (in default-supported-forms like json, xml, etc.)... eg.  

{
 "id":1,  /**This is id of person, to be sent in case of over-write previous prescriptions.*/
 "phone":1234567890, /**this is phone number of 10  digits, must be sent.*/
 "name":"patient (monty)", /**this is name of person, must be sent*/
 "prescribed_medicines": [ /**This is list of prescribed medicines*/
        
   {       
     "dosage_amount": 2000, /** This is amount needed to be taken by a person*/
      "timings": "before wake-up", /** this is timings of when to be taken*/
      "md":{
        "id":2, /** this is id of a person to be sent only when want to use previously prescribed medicine OR medicine has been found in front-end prescription-form*/
         "name":"test Medicine", /** this is name of medicine*/
        	"mfg_By":"l rights", /** this is name of manufacturing company*/
         "mktd_By":"VENR 2",   /**this is the name of marketing company*/
        	"chemicals":"Unknowm",  /**this is the name of chemical composition in medicine*/
          "any_other_note":"Not for the time being" /**this is optional note*/
      }
   }
 ]
}

Above is explanation of all fields.... To use a sample look at sample_input.txt file.
