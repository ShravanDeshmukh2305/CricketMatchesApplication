# Cricket Matches Application

## API Endpoint

### Get Cricket Match Stats

**Endpoint:**  
`GET http://localhost:8082/api/v1/cricket/stats`

**Headers:**  
- `apiKey`: `test-creds@2320`

### Response Example:

```json
{
    "teamName": "Hong Kong [HKG]",
    "highestScore": 219,
    "totalMatchesWith300Plus": 19
}
