<?php

namespace Database\Seeders;

use App\Models\User;
use Illuminate\Database\Seeder;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $users = [
            [
                'name' => 'Steven',
                'email' => 'sbudiman@student.ciputra.ac.id',
                'password' => bcrypt('123'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210012',
                'prodi_id' => 9,
                'route_id' => 2
            ],
            [
                'name' => 'Steven2',
                'email' => 'sbudiman2@student.ciputra.ac.id',
                'password' => bcrypt('123'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210012',
                'prodi_id' => 9,
                'route_id' => 2
            ],
            [
                'name' => 'Maverick',
                'email' => 'test@email.com',
                'password' => bcrypt('123'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210023',
                'prodi_id' => 9,
                'route_id' => 1
            ],
            [
                'name' => 'Alice',
                'email' => 'alice@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210034',
                'prodi_id' => 9,
                'route_id' => 3
            ],
            [
                'name' => 'Bob',
                'email' => 'bob@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210045',
                'prodi_id' => 9,
                'route_id' => 4
            ],
            [
                'name' => 'Charlie',
                'email' => 'charlie@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210056',
                'prodi_id' => 9,
                'route_id' => 5
            ],
            [
                'name' => 'David',
                'email' => 'david@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210067',
                'prodi_id' => 9,
                'route_id' => 6
            ],
            [
                'name' => 'Eve',
                'email' => 'eve@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210078',
                'prodi_id' => 9,
                'route_id' => 1
            ],
            [
                'name' => 'Frank',
                'email' => 'frank@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210089',
                'prodi_id' => 9,
                'route_id' => 7
            ],
            [
                'name' => 'Grace',
                'email' => 'grace@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210090',
                'prodi_id' => 9,
                'route_id' => 2
            ],
            [
                'name' => 'Hank',
                'email' => 'hank@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210101',
                'prodi_id' => 9,
                'route_id' => 3
            ],
            [
                'name' => 'Ivy',
                'email' => 'ivy@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210112',
                'prodi_id' => 9,
                'route_id' => 4
            ],
            [
                'name' => 'Jack',
                'email' => 'jack@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210123',
                'prodi_id' => 9,
                'route_id' => 5
            ],
            [
                'name' => 'Kathy',
                'email' => 'kathy@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210134',
                'prodi_id' => 9,
                'route_id' => 6
            ],
            [
                'name' => 'Leo',
                'email' => 'leo@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210145',
                'prodi_id' => 9,
                'route_id' => 1
            ],
            [
                'name' => 'Mona',
                'email' => 'mona@example.com',
                'password' => bcrypt('password'),
                'photo' => 'https://yourteachingmentor.com/wp-content/uploads/2020/12/istockphoto-1223671392-612x612-1.jpg',
                'nim' => '0706012210156',
                'prodi_id' => 9,
                'route_id' => 7
            ]
        ];

        foreach ($users as $user) {
            User::create($user);
        }
    }
}
