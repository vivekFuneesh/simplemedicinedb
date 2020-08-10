# simplemedicinedb
 A "DEMO" medicine prescription platform 
				Under GPL v3 License
::End points are::

    @PostMapping("/rest/add/")
    
   	@GetMapping("/rest/prescriptions")
  
Above are rest end points.
For get end point, "/view/prescriptions" can also be used by client views.
Get request over path /prescriptions?phone=  
here, this phone is the unique identifier of the person whose prescriptions are to be retrieved.
  <br>
Post request over path /add/ requires a person object (in default-supported-forms like json, xml, etc.)... eg.  <br><br>
Phone number will act as unique identifier and must be of length 10 only.<br>
(Disclaimer): Phone number used below is just a demo number...., I don't own or have any relation to this number.
~~~
{
   "phone":9871237654,    
   "name":" Monty", 
    "prescribed_medicines": [
        
        {       
            "dosage_amount": 1,
            "timings": "before sleep",
            "md":{
                
               "name":"covid Medicine",

            	"mfg_By":"Vivek Co. Ltd.",
	
                "mktd_By":"Processcom med Pvt. Ltd.",
	
            	"chemicals":"Unknowm",
    
                "any_other_note":" Magic"
            }
        }
    ]
}
~~~


Above is self-explanatory of all fields....
