package com.example.laboranaiarabota;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class FileLab {
    private final String path;
    private final byte[] value;
}
