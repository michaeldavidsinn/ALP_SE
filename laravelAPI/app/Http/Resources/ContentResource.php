<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class ContentResource extends JsonResource
{
    /**
     * Transform the resource collection into an array.
     *
     * @return array<int|string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'id'=>$this->id,
            'headline'=>$this->headline,
            'image'=>$this->image,
            'content_text'=>$this->content_text,
            'created_at'=>date_format($this->created_at, 'Y-m-d H:i:s')
        ];
    }
}
