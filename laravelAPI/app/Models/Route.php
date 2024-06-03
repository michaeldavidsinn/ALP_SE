<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Route extends Model
{
    use HasFactory;

    protected $fillable = [
        'destination',
        'max',
        'school',
        'distance'

    ];
    

    public function users(){
        return $this->hasMany(User::class);
    }
}
