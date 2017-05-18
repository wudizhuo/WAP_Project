mongoimport --db wap --collection User --drop --file script/user.json
mongoimport --db wap --collection post_data --drop --file script/post_data.json
mongofiles put --db wap --local script/images/hamster.jpg hamster.jpg
