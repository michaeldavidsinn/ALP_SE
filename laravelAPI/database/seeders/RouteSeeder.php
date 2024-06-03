<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\Route;


use Carbon\Carbon;

class RouteSeeder extends Seeder
{
    public function run()
    {

        Route::create([
            'destination' => 'null',
            'max' => 0,
            'school' => 'null',
            'distance' => 0,
            'departure' => '',
            'driver' => ''

        ]);

        Route::create([
            'destination' => 'Central Park',
            'max' => 4,
            'school' => 'Lincoln High School',
            'distance' => 10.5,
            'departure' => Carbon::now()->addHours(1),
            'driver' => 'Driver A'

        ]);

        Route::create([
            'destination' => 'Madison Square',
            'max' => 5,
            'school' => 'Roosevelt Elementary School',
            'distance' => 5.2,
            'departure' => Carbon::now()->addHours(2),
            'driver' => 'Driver B'

        ]);

        Route::create([
            'destination' => 'Union Station',
            'max' => 4,
            'school' => 'Kennedy Middle School',
            'distance' => 15.3,
            'departure' => Carbon::now()->addHours(3),
            'driver' => 'Driver C'

        ]);

        Route::create([
            'destination' => 'Greenwood Mall',
            'max' => 5,
            'school' => 'Franklin High School',
            'distance' => 7.8,
            'departure' => Carbon::now()->addHours(4),
            'driver' => 'David Sin'

        ]);

        Route::create([
            'destination' => 'Riverside Park',
            'max' => 4,
            'school' => 'Jefferson Elementary School',
            'distance' => 12.1,
            'departure' => Carbon::now()->addHours(5),
            'driver' => 'Kimi Harisen'

        ]);

        Route::create([
            'destination' => 'Sunset Boulevard',
            'max' => 5,
            'school' => 'Washington Middle School',
            'distance' => 9.6,
            'departure' => Carbon::now()->addHours(6),
            'driver' => 'Steven Nelson'

        ]);
    }
}
