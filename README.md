# Si-Converter

This project presents a solution for a coding challange.

The challange is:
  - Create a service to provide a single endpoit to convert units to the International System Unit (SI), returning it's equivalent SI unit string and a multiplication factor for the client to realize the conversion.
  > For example, a call to GET /units/si?units=(degree/minute) should get the following response:
   
```json
{
  "unit_name": "(rad/s)",
  "multiplication_factor": 0.0029088820866572
}
```

where unit_name is the names of the units converted to the SI standards, and the multiplication factor is a floating point number used to convert the provided unit on the query string to it's equivalent SI unit.
