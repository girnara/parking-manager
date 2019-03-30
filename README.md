# Parking Manager

Parking Management Service - A multi tenant in memory parking management service(Assumed pricing for both LARGE and MOTORBIKE are same. We can make it configurable).

## Getting Started

Clone the github repository in your workspace
```
$ cd $WORK_SPACE/
$ git clone https://github.com/girnara/parking-manager.git
$ cd parking-manager
$ ./mvnw clean package
$ java -jar parking-application/target/parking-application-0.0.1-exec.jar
```

### Prerequisites

You need to install java 1.8 on your system before starting this project.

```
Install JAVA 1.8 on your development environment
```

### Installing

Once application is up and running

You can see the APIs using swagger on following link

```
http://localhost:28080/v2/api-docs
http://localhost:28080/swagger-ui.html
```

Create Parking Lot for Test client(WeWorkParking - example json is available in parking-application/src/main/resource/data/parking-lot-request.json)
Select Admin Controller and create parking lot for clientId:WeWork, X-ACCESS-TOKEN:TEST(currently authentication is not implemented but in future we can do that using interceptors and springboot oauth2.0).

```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' --header 'X-ACCESS-TOKEN: TEST' -d '{
  "address": {
    "city": "Gurgaon",
    "country": "IN",
    "state": "HR",
    "streetAddress": "BlueOneSquare",
    "zipCode": "122001"
  },
  "entranceGates": [
    {
      "id": "GATE-ENTRY-1"
    }
  ],
  "exitGates": [
    {
      "id": "GATE-EXIT-1"
    }
  ],
  "id": "WeWorkParking",
  "largeSpotCount": 0,
  "maxLargeCount": 20,
  "maxMotorbikeCount": 20,
  "motorbikeSpotCount": 0,
  "name": "weWorkBlueOneSquare",
  "parkingFloors": [
    {
      "largeSpots": {
        "1": {
          "type":"LARGE",
          "free": true
        },
        "2": {
          "type":"LARGE",
          "free": true
        },
        "3": {
          "type":"LARGE",
          "free": true
        },
        "4": {
          "type":"LARGE",
          "free": true
        },
        "5": {
          "type":"LARGE",
          "free": true
        },
        "6": {
          "type":"LARGE",
          "free": true
        },
        "7": {
          "type":"LARGE",
          "free": true
        },
        "8": {
          "type":"LARGE",
          "free": true
        },
        "9": {
          "type":"LARGE",
          "free": true
        },
        "10": {
          "type":"LARGE",
          "free": true
        }
      },
      "motorbikeSpots": {
        "11": {
          "type":"MOTORBIKE",
          "free": true
        },
        "12": {
          "type":"MOTORBIKE",
          "free": true
        },
        "13": {
          "type":"MOTORBIKE",
          "free": true
        },
        "14": {
          "type":"MOTORBIKE",
          "free": true
        },
        "15": {
          "type":"MOTORBIKE",
          "free": true
        },
        "16": {
          "type":"MOTORBIKE",
          "free": true
        },
        "17": {
          "type":"MOTORBIKE",
          "free": true
        },
        "18": {
          "type":"MOTORBIKE",
          "free": true
        },
        "19": {
          "type":"MOTORBIKE",
          "free": true
        },
        "20": {
          "type":"MOTORBIKE",
          "free": true
        }
      },
      "name": "LEVEL-B1"
    },
    {
      "largeSpots": {
        "101": {
          "type":"LARGE",
          "free": true
        },
        "102": {
          "type":"LARGE",
          "free": true
        },
        "103": {
          "type":"LARGE",
          "free": true
        },
        "104": {
          "type":"LARGE",
          "free": true
        },
        "105": {
          "type":"LARGE",
          "free": true
        },
        "106": {
          "type":"LARGE",
          "free": true
        },
        "107": {
          "type":"LARGE",
          "free": true
        },
        "108": {
          "type":"LARGE",
          "free": true
        },
        "109": {
          "type":"LARGE",
          "free": true
        },
        "110": {
          "type":"LARGE",
          "free": true
        }
      },
      "motorbikeSpots": {
        "111": {
          "type":"MOTORBIKE",
          "free": true
        },
        "112": {
          "type":"MOTORBIKE",
          "free": true
        },
        "113": {
          "type":"MOTORBIKE",
          "free": true
        },
        "114": {
          "type":"MOTORBIKE",
          "free": true
        },
        "115": {
          "type":"MOTORBIKE",
          "free": true
        },
        "116": {
          "type":"MOTORBIKE",
          "free": true
        },
        "117": {
          "type":"MOTORBIKE",
          "free": true
        },
        "118": {
          "type":"MOTORBIKE",
          "free": true
        },
        "119": {
          "type":"MOTORBIKE",
          "free": true
        },
        "120": {
          "type":"MOTORBIKE",
          "free": true
        }
      },
      "name": "LEVEL-B2"
    }
  ],
  "parkingRate": {
    "dayTypeHourlyRate": {
      "DEFAULT": 10.5,
      "WEEKENDS": 25.5
    }
  }
}' 'http://localhost:28080/v1/admin/WeWork'
```

Response Json:

```
{
  "status": "SUCCESS",
  "statusMessage": "Successfully processed your request",
  "payload": {
    "id": "ec3e6dd8-3315-4861-a723-a3012cd5ee62",
    "name": "weWorkBlueOneSquare",
    "address": {
      "streetAddress": "BlueOneSquare",
      "city": "Gurgaon",
      "state": "HR",
      "zipCode": "122001",
      "country": "IN"
    },
    "parkingRate": {
      "dayTypeHourlyRate": {
        "DEFAULT": 10.5,
        "WEEKENDS": 25.5
      }
    },
    "largeSpotCount": 0,
    "motorbikeSpotCount": 0,
    "maxLargeCount": 20,
    "maxMotorbikeCount": 20,
    "entranceGates": [
      {
        "id": "GATE-ENTRY-1"
      }
    ],
    "exitGates": [
      {
        "id": "GATE-EXIT-1"
      }
    ],
    "parkingFloors": [
      {
        "name": "LEVEL-B1",
        "largeSpots": {
          "1": {
            "type": "LARGE"
          },
          "2": {
            "type": "LARGE"
          },
          "3": {
            "type": "LARGE"
          },
          "4": {
            "type": "LARGE"
          },
          "5": {
            "type": "LARGE"
          },
          "6": {
            "type": "LARGE"
          },
          "7": {
            "type": "LARGE"
          },
          "8": {
            "type": "LARGE"
          },
          "9": {
            "type": "LARGE"
          },
          "10": {
            "type": "LARGE"
          }
        },
        "motorbikeSpots": {
          "11": {
            "type": "MOTORBIKE"
          },
          "12": {
            "type": "MOTORBIKE"
          },
          "13": {
            "type": "MOTORBIKE"
          },
          "14": {
            "type": "MOTORBIKE"
          },
          "15": {
            "type": "MOTORBIKE"
          },
          "16": {
            "type": "MOTORBIKE"
          },
          "17": {
            "type": "MOTORBIKE"
          },
          "18": {
            "type": "MOTORBIKE"
          },
          "19": {
            "type": "MOTORBIKE"
          },
          "20": {
            "type": "MOTORBIKE"
          }
        }
      },
      {
        "name": "LEVEL-B2",
        "largeSpots": {
          "101": {
            "type": "LARGE"
          },
          "102": {
            "type": "LARGE"
          },
          "103": {
            "type": "LARGE"
          },
          "104": {
            "type": "LARGE"
          },
          "105": {
            "type": "LARGE"
          },
          "106": {
            "type": "LARGE"
          },
          "107": {
            "type": "LARGE"
          },
          "108": {
            "type": "LARGE"
          },
          "109": {
            "type": "LARGE"
          },
          "110": {
            "type": "LARGE"
          }
        },
        "motorbikeSpots": {
          "111": {
            "type": "MOTORBIKE"
          },
          "112": {
            "type": "MOTORBIKE"
          },
          "113": {
            "type": "MOTORBIKE"
          },
          "114": {
            "type": "MOTORBIKE"
          },
          "115": {
            "type": "MOTORBIKE"
          },
          "116": {
            "type": "MOTORBIKE"
          },
          "117": {
            "type": "MOTORBIKE"
          },
          "118": {
            "type": "MOTORBIKE"
          },
          "119": {
            "type": "MOTORBIKE"
          },
          "120": {
            "type": "MOTORBIKE"
          }
        }
      }
    ],
    "activeTickets": {}
  }
}
```

## Create parking ticket

Goto http://localhost:28080/swagger-ui.html#!/parking-controller/parkUsingPOST and provide parking-application/src/main/resources/data/parking-request.json
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' --header 'X-ACCESS-TOKEN: TEST' -d '{
  "registrationNumber": "HR26-AB1234",
  "class": "girnara.abhay.parking.domain.model.vehicles.Bus"
}' 'http://localhost:28080/v1/parking/WeWork'
```

Response Json:
```
{
  "status": "SUCCESS",
  "statusMessage": "Successfully processed your request",
  "payload": {
    "id": "564d735d-f70d-492e-9c7b-9eb11a5198b5",
    "timestamp": 1553984338698,
    "issueAt": 1553984338658,
    "payedAmount": 0,
    "status": "ACTIVE"
  }
}
```

## Un Park and Pay for parking
Goto http://localhost:28080/swagger-ui.html#!/parking-controller/unParkUsingPUT and provide the ticketId, clientId as given in example

```
curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' --header 'X-ACCESS-TOKEN: TEST' 'http://localhost:28080/v1/parking/WeWork/564d735d-f70d-492e-9c7b-9eb11a5198b5'
```

Response Json
```
{
  "status": "SUCCESS",
  "statusMessage": "Successfully processed your request",
  "payload": {
    "id": "8c4f1313-39e3-4fee-85de-431275ab0e55",
    "parkingSpotId": "1",
    "timestamp": 1553986160345,
    "issueAt": 1553986160304,
    "payedAmount": 10.5,
    "status": "PAID"
  }
}
```

## Deployment

Deployment folder contain the ansible role for deployment on ubuntu 16.04 as systemctl service with slack notification
Export your build number as 100(It can be your jenkins build number. You need to add the ssh public key on target hosts
```
$ export BUILD_NUMBER=100
$ mkdir -p deployment/application/$BUILD_NUMBER
$ cp parking-application/target/parking-application-0.0.1-exec.jar deployment/application/$BUILD_NUMBER/parking-application-0.0.1.jar
$ cd deployment
$ sudo ansible-playbook -e "env=dev" -e "region=in"  -e "BUILD_NUMBER=100" -i inventory/awsdev-hosts site.yml
```




## Authors

* **Abhay Girnara** - *Initial work* - [girnara](https://github.com/girnara)
