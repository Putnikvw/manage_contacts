# REST API example application

This is a test application providing a REST API.
# REST API

The REST API to the example app is described below.

## Get list of Contatcs

### Request

`GET /api/v1/contacts`

    curl -i -H 'Accept: application/json' http://localhost:8080/api/v1/contacts

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 2

    []

## Create a new Contact

### Request

`POST /api/v1/contacts`

    curl -i -H 'Accept: application/json' -d { "fullName": "John Wick", "birthday": "2015-03-01", "address": {"city": "Kyiv","postCode": "12345"}} http://localhost:8080/api/v1

### Response

    HTTP/1.1 201 Created
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /api/v1

    {   "id": 1,
        "key": "c4798a79-a50e-4efb-bb6a-2268a0d966f2",
        "fullName": "John Wick",
        "birthday": "2015-03-01",
        "address": {
            "id": 1,
            "city": "Kyiv",
            "postCode": "12345"
        }
    }

## Get a specific Contacts based on post code

### Request

`GET /api/v1/contacts?postcode=?`

    curl -i -H 'Accept: application/json' http://localhost:8080/api/v1/contacts?postcode=12345

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json

    [
        {
            "id": 1,
            "key": "c49dbc69-c0b1-4ed9-b77b-ba002b0ad943",
            "fullName": "Alan Walker",
            "birthday": "2015-03-01",
            "address": {
                "id": 1,
                "city": "Berlin",
                "postCode": "12345"
            }
        }
    ]