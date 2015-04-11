# Police UK API
1. Get GPS coordinates, e.g:
51.4587662,-0.3075401 - Paypal HQ, London neighbourhood

2. Get force and neighbourhood: https://data.polie.uk/api/locate-neighbourhood?q=51.4598809,-0.3089441
metropolitan: 00BD07N

3. Get closest police station: https://data.police.uk/api/metropolitan/00BD07N

4. Neighbourhood boundary: https://data.police.uk/api/metropolitan/00BD07N/boundary

5. Crime data in neighbourhood in last month:
http://www.police.uk/metropolitan/00BD07N/crime/data/

6. Get crimes at specific location
https://data.police.uk/api/crimes-at-location?date=2015-02&lat=51.4587662&lng=-0.3075401
Or https://data.police.uk/api/crimes-at-location?date=2015-02&location_id=923959